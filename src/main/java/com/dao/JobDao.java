package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Jobs;

import sun.security.util.math.intpoly.P256OrderField;

public class JobDao {
	
	private Connection connection;

	public JobDao(Connection connection) {
		super();
		this.connection = connection;
	}
	
	public boolean addJob(Jobs j) {
		
		boolean f=false;
		try {
			String sql = "insert into jobs (title,description,category,status,location ) values (?,?,?,?,?)";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Jobs> getAllJobs() {
		List<Jobs> jobList = new ArrayList<Jobs>();		
		Jobs jobs= null;
		
		try {
			String sql= "select * from jobs order by id desc";
			PreparedStatement ps=connection.prepareStatement(sql);
			ResultSet rs=ps.executeQuery(sql);
			while (rs.next()) {
				jobs= new Jobs();
				jobs.setId(rs.getInt(1));
				jobs.setTitle(rs.getString(2));
				jobs.setDescription(rs.getString(3));
				jobs.setCategory(rs.getString(4));
				jobs.setStatus(rs.getString(5));
				jobs.setLocation(rs.getString(6)); 
				jobs.setPdate(rs.getTimestamp(7)+"");
				jobList.add(jobs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return jobList;
	}
	
	public Jobs getJobByID(int id) {				
		Jobs job= null;		
		try {
			String sql= "select * from jobs where id="+id;
			PreparedStatement ps=connection.prepareStatement(sql);
			//ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(sql);
			while (rs.next()) {
				job= new Jobs();
				job.setId(rs.getInt(1));
				job.setTitle(rs.getString(2));
				job.setDescription(rs.getString(3));
				job.setCategory(rs.getString(4));
				job.setStatus(rs.getString(5));
				job.setLocation(rs.getString(6)); 
				job.setPdate(rs.getTimestamp(7)+"");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return job;
	}
	
	public boolean updateJob(Jobs j) {
		boolean f=false;
		try {
			String sql = "update jobs set title=?,description=?,category=?,status=?,location=? where id=?";
			PreparedStatement ps =connection.prepareStatement(sql);
			ps.setString(1, j.getTitle());
			ps.setString(2, j.getDescription());
			ps.setString(3, j.getCategory());
			ps.setString(4, j.getStatus());
			ps.setString(5, j.getLocation());
			ps.setInt(6, j.getId());
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public boolean deleteJob(Integer id) {
		boolean f=false;
		try {
			String sql = "delete from jobs where id=?";
			PreparedStatement ps =connection.prepareStatement(sql);			
			ps.setInt(1, id);	
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
