/*
 * @(#)$Id: Quote.java 1087 2011-05-25 05:28:29Z hirai $
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
package jp.powerbase.xquery.expr;

public class Quote implements Wrappable {
	private char quote;

	public Quote() {
		this('"');
	}

	public Quote(char quote) {
		this.quote = quote;
	}

	@Override
	public String wrap(String contents) {
		StringBuffer str = new StringBuffer();
		str.append(quote);
	    StringBuffer s = new StringBuffer(contents);
	    for(int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        str.append(c);
	        if (c == quote) {
	        	str.append(quote);
	        }
	    }
		str.append(quote);
		return str.toString();
	}
}
