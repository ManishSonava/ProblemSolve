package com.manishsonava.tSystem.service.extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.manishsonava.tSystem.model.LinkType;
import com.manishsonava.tSystem.model.SiteData;

public class ImageDataExtractor implements DataExtractor {
	
	private final static Pattern IMAGE_PATTERN = Pattern.compile("<img\\s+(?:[^>]*?\\s+)?src=([\"'])(.*?)\\1", Pattern.CASE_INSENSITIVE);


	@Override
	public SiteData getLinkDetails(String line) {
		SiteData data = new SiteData();

		Matcher matcher = IMAGE_PATTERN.matcher(line);
		if (matcher.find()) {
			data.setLink(matcher.group(1).trim());
		}
		data.setLinkType(LinkType.IMAGE);
		return data;
	}

}
