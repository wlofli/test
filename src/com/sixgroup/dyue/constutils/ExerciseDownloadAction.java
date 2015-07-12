package com.sixgroup.dyue.constutils;



import java.io.FileInputStream;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;





public class ExerciseDownloadAction {
	
	
	private String fileName="test.doc" ; //服务器文件名
	private String downloadFileName;//downloadfilename 下载文件名
	private String fileid;
//	private Exercise exercise;
	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public void setDownloadFileName(String downloadFileName) {
		try {
			this.downloadFileName = new String(downloadFileName.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setFileName(String fileName){ 
	   this.fileName = fileName; 
	}

	

	public InputStream getDownloadFile() throws Exception {		
		return new  FileInputStream("e:/test/exercise/"+fileName);    
	} 

	public String getDownloadFileName() {
		return downloadFileName;
	}

	public String execute() throws Exception { 
		System.out.println("exercisedownload");
	    ExerciseDAO dao =new ExerciseDAO();
	    Exercise ex= new Exercise();	   
	    ex=dao.loadExercise(exercise.getElexId()); 
	    this.setDownloadFileName(ex.getElexName());
	    System.out.println(downloadFileName);
	    fileName=new String(ex.getElexName()+ex.getElexId());	  
	    return "success"; 
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	} 
	
	
}
