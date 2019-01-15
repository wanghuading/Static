package com.sz.demo.adaptive;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.registry.RegistryFactory;

public class RegistryFactory$Adpative implements com.alibaba.dubbo.registry.RegistryFactory {
	public com.alibaba.dubbo.registry.Registry getRegistry(com.alibaba.dubbo.common.URL arg0) {
		if (arg0 == null) throw new IllegalArgumentException("url == null");
		com.alibaba.dubbo.common.URL url = arg0;
		String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
		if (extName == null)
			throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.registry.RegistryFactory) name from url(" + url.toString() + ") use keys([protocol])");
		RegistryFactory extension =  ExtensionLoader.getExtensionLoader(RegistryFactory.class).getExtension(extName);
		return extension.getRegistry(arg0);
	}
}
