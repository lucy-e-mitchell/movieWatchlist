package com.lucymitchell.movieWatchlist.service;

import com.lucymitchell.movieWatchlist.remote.OMBDService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class OMBDHelper {

    private final OMBDService ombdService;

    public Map<String, Object> getMovieByTitle(String title){
        Map<String, Object> results = new HashMap<>();
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("t", title);
        String params = getParamsString(paramMap);
        if (params != ""){
            results = ombdService.getMovieByTitle(params);
        }
        return results;
    }

    private static String getParamsString(Map<String, String> params) {
        try {
            StringBuilder result = new StringBuilder();

            for (Map.Entry<String, String> entry : params.entrySet()) {
                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                result.append("&");
            }

            String resultString = result.toString();
            return resultString.length() > 0
                    ? resultString.substring(0, resultString.length() - 1)
                    : resultString;
        } catch (IOException e) {
            System.out.println("Error building params" + e);
            return "";
        }
    }
}
