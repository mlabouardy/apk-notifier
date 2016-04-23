package com.labouardy.converter;

import java.util.function.Function;
import com.labouardy.model.Apk;
import com.labouardy.model.Release;

public class ReleaseConverter{
	
	public static Function<Release, Apk> convertToApk(){
		return new Function<Release, Apk>(){
			@Override
			public Apk apply(Release t) {
				Apk apk=new Apk();
				apk.setName(t.getName());
				apk.setDescription(t.getDescription());
				apk.setPublishedAt(t.getPublishedAt());
				apk.setTag(t.getTag());
				apk.setUrl(t.getUrl());
				return apk;
			}};
	}

}
