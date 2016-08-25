package com.uploadfile.fileresource;

import java.io.IOException;

import org.springframework.core.io.Resource;

public class FileResource 
{
	private Resource resource;
	private String FileName;
	private long contLength;
	
	public void setResource(Resource resource)
	{
		this.resource = resource;
	}
	
	public Resource getResource()
	{
		return resource;
	}
	
	public String getFileName()
	{
		FileName = resource.getFilename();
		return FileName;
	}
	
	public long getContLength() throws IOException
	{
		contLength = resource.contentLength();
		return contLength;
	}

}
