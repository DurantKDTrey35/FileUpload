package com.uploadfile.fileuploadcontroller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileUploadController 
{
	private static ResourceLoader resourceLoader;
	
	private static final String ROOT = "upload-dir";
	
	//@AutoWired ?
	public void FileUploadController(ResourceLoader resourceLoader)
	{
		this.resourceLoader = resourceLoader;
	}
	
	//Define a holder to our files with needed extension
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String addToHolder(Model model, final String extension) throws IOException
	{
		model.addAttribute("files", Files.walk(Paths.get(ROOT))
		.filter((path) -> !path.equals(Paths.get(ROOT))
		 && path.toFile().getAbsolutePath().endsWith(extension))
		.collect(Collectors.toList()));
		//.filter(path -> !path.toFile().getAbsolutePath().endWith(extension))
		
		return "upload-form";
	}
	
	@RequestMapping(value="/{filename}", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getFile(@PathVariable String fileName)
	{
		try
		{
			return ResponseEntity.ok(resourceLoader.getResource("file:"+Paths.get(ROOT, fileName).toString()));
		}
		catch (final Exception e)
		{
			return ResponseEntity.notFound().build();
		}
		
	}
	
}

