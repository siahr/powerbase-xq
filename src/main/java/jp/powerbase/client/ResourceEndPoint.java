/*
 * @(#)$Id: ResourceEndPoint.java 1087 2011-05-25 05:28:29Z hirai $
 *
 * Copyright 2005-2011 Infinite Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Toshio HIRAI - initial implementation
 */
package jp.powerbase.client;

import java.net.MalformedURLException;
import java.net.URL;

import jp.powerbase.xmldb.resource.Path;

public class ResourceEndPoint implements EndPoint {
	private final URL url;
	private final URL serverLocation;
	private final String resourceLocationPath;

	public ResourceEndPoint(URL serverLocation, Path resourceLocationPath) throws MalformedURLException {
		this.serverLocation = serverLocation;
		this.resourceLocationPath = resourceLocationPath.getPath();

		String s = "";
		if (serverLocation.toString().endsWith("/")) {
			s = serverLocation.toString().substring(0, serverLocation.toString().length() - 1);
		} else {
			s = serverLocation.toString();
		}
		s += this.resourceLocationPath;
		url = new URL(s);

	}

	public String toString() {
		return url.toString();
	}

	/**
	 * url
	 *
	 * @return url
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * serverLocation
	 *
	 * @return serverLocation
	 */
	public URL getServerLocation() {
		return serverLocation;
	}

}
