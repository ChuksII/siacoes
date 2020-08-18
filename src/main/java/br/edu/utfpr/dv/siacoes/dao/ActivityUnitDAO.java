package br.edu.utfpr.dv.siacoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.dv.siacoes.log.UpdateEvent;
import br.edu.utfpr.dv.siacoes.model.ActivityUnit;

public class ActivityUnitDAO {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;


	public List<ActivityUnit> listAll() throws SQLException{
		try{
			conn = ConnectionDAO.getInstance().getConnection();
			stmt = conn.createStatement();
		
			rs = stmt.executeQuery("SELECT * FROM activityunit ORDER BY description");
			
			List<ActivityUnit> list = new ArrayList<ActivityUnit>();
			
			while(rs.next()){
				list.add(this.loadObject(rs));
			}
			
			return list;
		}finally{
			if((rs != null) && !rs.isClosed())
				rs.close();
			if((stmt != null) && !stmt.isClosed())
				stmt.close();
			if((conn != null) && !conn.isClosed())
				conn.close();
		}
	}
	
	public ActivityUnit findById(int id) throws SQLException{

		try{
			conn = ConnectionDAO.getInstance().getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM activityunit WHERE idActivityUnit=?");
		
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();

			return rs.next() ? this.loadObject(rs) : null;
		}finally{
			if((rs != null) && !rs.isClosed())
				rs.close();
			if((pstmt != null) && !pstmt.isClosed())
				pstmt.close();
			if((conn != null) && !conn.isClosed())
				conn.close();
		}
	}
	
	public int save(int idUser, ActivityUnit unit) throws SQLException{
		boolean insert = (unit.getIdActivityUnit() == 0);

		try{
			conn = ConnectionDAO.getInstance().getConnection();

			if(insert){
				pstmt = conn.prepareStatement("INSERT INTO activityunit(description, fillAmount, amountDescription) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			}else{
				pstmt = conn.prepareStatement("UPDATE activityunit SET description=?, fillAmount=?, amountDescription=? WHERE idActivityUnit=?");
			}
			
			pstmt.setString(1, unit.getDescription());
			pstmt.setInt(2, (unit.isFillAmount() ? 1 : 0));
			pstmt.setString(3, unit.getAmountDescription());
			
			if(!insert){
				pstmt.setInt(4, unit.getIdActivityUnit());
			}
			
			pstmt.execute();


			if(insert){
				rs = pstmt.getGeneratedKeys();
				
				if(rs.next()){
					unit.setIdActivityUnit(rs.getInt(1));
				}
				
				new UpdateEvent(conn).registerInsert(idUser, unit);
			} else {
				new UpdateEvent(conn).registerUpdate(idUser, unit);
			}
			
			return unit.getIdActivityUnit();
		}finally{
			if((rs != null) && !rs.isClosed())
				rs.close();
			if((pstmt != null) && !pstmt.isClosed())
				pstmt.close();
			if((conn != null) && !conn.isClosed())
				conn.close();
		}
	}
	
	private ActivityUnit loadObject(ResultSet rs) throws SQLException{
		ActivityUnit unit = new ActivityUnit();
		
		unit.setIdActivityUnit(rs.getInt("idActivityUnit"));
		unit.setDescription(rs.getString("Description"));
		unit.setFillAmount(rs.getInt("fillAmount") == 1);
		unit.setAmountDescription(rs.getString("amountDescription"));
		
		return unit;
	}

}
