/*******************************************************************************
 * Copyright 2011-2013 Sergey Tarasevich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.nostra13.universalimageloader.cache.disc.naming;

import android.net.Uri;
import android.util.Log;

import java.util.Set;

/**
 * Names image file as image URI {@linkplain String#hashCode() hashcode}
 *
 * @author Sergey Tarasevich (nostra13[at]gmail[dot]com)
 * @since 1.3.1
 */

public
class SlippyFileNameGenerator implements FileNameGenerator {
	@Override
	//https://crowdais.com/ais/boatwatchtile.php?a={z}&b={x}&c={y}&tag=ukr..."
	public String generate(String imageUri) {
		Uri uri = Uri.parse(imageUri);
		String server = uri.getAuthority();
		String path = uri.getPath();
		String protocol = uri.getScheme();
		Set<String> args = uri.getQueryParameterNames();
		String tag = uri.getQueryParameter("tag");
		String x = uri.getQueryParameter("x");
		String y = uri.getQueryParameter("y");
		String z = uri.getQueryParameter("z");
		String imgfilename=tag+"/" + z +"/" + x +"/" + y +".png";
        Log.i("SlippyFileNameGenerator",imgfilename);
		return imgfilename;
	}
}
