/*
 * @(#)$Id: CreateGroup.java 1178 2011-07-22 10:16:56Z hirai $
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
package jp.powerbase.client.command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.w3c.dom.Document;

import jp.powerbase.Command;
import jp.powerbase.client.Client;
import jp.powerbase.client.CommandInvoker;
import jp.powerbase.client.Connector;
import jp.powerbase.client.RequestElement;
import jp.powerbase.constant.HttpRequest.Method;
import jp.powerbase.util.XMLUtil;

public class CreateGroup extends Invoker implements CommandInvoker {
	private final Command command = Command.CREATE_GROUP;

	public CreateGroup(Connector connector, Document xml) throws NoSuchAlgorithmException, IOException {
		client = new Client(connector.getUser(), Method.POST, connector.getServer().getUrl());
		RequestElement rt = new RequestElement(command);
		req = new InputStreamRequestEntity(new ByteArrayInputStream(rt.wrap(XMLUtil.documentToString(xml, false)).getBytes()));
	}

}
