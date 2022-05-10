package sn.lamp.Ecommerce.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.lamp.Ecommerce.service.uploadService;

@Service
public class uploadServiceIpml implements uploadService {
	@Autowired
	ServletContext context;

	@Override
	public File getPathService(String fileName, String path) {
		boolean exits = new File(context.getRealPath("/" + path + "/")).exists();
		if (!exits)
			new File(context.getRealPath("/" + path + "/")).mkdir();
		String yone = context.getRealPath("/" + path + "/" + fileName);
		File fil = new File(yone);
		return fil;
	}

}
