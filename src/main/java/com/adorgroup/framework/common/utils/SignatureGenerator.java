package com.adorgroup.framework.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class SignatureGenerator {

    public SignatureGenerator() {
    }

    public static String generate(String urlResourcePart, Map<String, String> params, String secretKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        List<Map.Entry<String, String>> parameters = new LinkedList(params.entrySet());
        Collections.sort(parameters, new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(urlResourcePart).append("_");
        Iterator pars = parameters.iterator();

        while(pars.hasNext()) {
            Map.Entry<String, String> param = (Map.Entry)pars.next();
            sb.append(param.getKey()).append("=").append(param.getValue()).append("_");
        }

        sb.append(secretKey);
        String baseString = URLEncoder.encode(sb.toString(), "UTF-8");
        return MD5Util.md5(baseString);
    }
}
