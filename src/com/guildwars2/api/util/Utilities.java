package com.guildwars2.api.util;

//The MIT License (MIT)
//
//Copyright (c) <2013> <Petr Prokop>
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in
//all copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
//THE SOFTWARE.

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class Utilities {
	
	/**
	 * Build query string for API
	 * 
	 * @param action
	 *            json action
	 * @param params
	 *            map of parameters
	 * @return string describing URL of request
	 */
	private static String buildQuerryString(String action, Map<String, Object> params) {
		StringBuffer querry = new StringBuffer();
		querry.append(GW2APIJSON.STANDARD_URL).append(GW2APIJSON.API_VERSION).append("/").append(action);
		if (params != null) {
			if (!params.isEmpty()) {
				querry.append("?");
			}
			boolean first = true;
			for (Entry<String, Object> param : params.entrySet()) {
				if (first) {
					first = false;
				} else {
					querry.append("&");
				}
				querry.append(param.getKey()).append("=").append(param.getValue());
			}
		}
		return querry.toString();
	}

	/**
	 * Build query string for API
	 * 
	 * @param action
	 *            json action
	 * @param params
	 *            map of parameters
	 * @return string describing URL of request
	 */
	static URL buildQuerryURL(String action, Map<String, Object> params) throws MalformedURLException {
		return new URL(buildQuerryString(action, params));
	}

}