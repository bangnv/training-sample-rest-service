/*
 * Copyright (C) 2003-2012 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.cross.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import org.exoplatform.services.rest.resource.ResourceContainer;

/**
 * Created by The eXo Platform SAS Author : eXoPlatform bangnv@exoplatform.com
 * Sep 24, 2012
 */

@Path("/dateService/")
public class DateService implements ResourceContainer {

	// http://localhost:8080/rest/dateService/diffDate/11-05-2011/11-07-2012/Min
	// http://localhost:8080/rest/dateService/diffDate/11-05-2011/11-07-2012/Hour
	// http://localhost:8080/rest/dateService/diffDate/11-05-2011/11-07-2012/Day
	@GET
	@Path("/diffDate/{date1}/{date2}/{resultType}")
	public String diffDate(@PathParam("date1") String date1,
			@PathParam("date2") String date2,
			@PathParam("resultType") String resultType) {
		String errorMsg = "url is not in correct format. Good url ex :  http://localhost:8080/rest/dateService/diffDate/11-05-2011/11-07-2012/Min";
		if (date1 == null || date2 == null) {
			return errorMsg;
		}
		Date dateConvert1, dateConvert2;
		try {
			dateConvert1 = new SimpleDateFormat("dd-MM-yy").parse(date1);
			dateConvert2 = new SimpleDateFormat("dd-MM-yy").parse(date2);
		} catch (ParseException e) {
			return errorMsg;
		}
		long result = Math.abs(dateConvert1.getTime() - dateConvert2.getTime());
		int finalResult;
		switch (Type.getType(resultType)) {
		case Min:
			finalResult = (int) (result / (1000 * 60));
			break;
		case Hour:
			finalResult = (int) (result / (1000 * 60 * 60));
			break;
		default:
			finalResult = (int) (result / (1000 * 60 * 60 * 24));
			break;
		}
		return String.valueOf(finalResult);
	}

	public enum Type {
		Min, Hour, Day;
		public static Type getType(String m) {
			if (m != null && m.equalsIgnoreCase("Min"))
				return Min;
			else if (m != null && m.equalsIgnoreCase("Hour"))
				return Hour;
			else
				return Day;
		}
	}
}
