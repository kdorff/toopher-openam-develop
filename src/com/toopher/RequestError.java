package com.toopher;

import java.io.IOException;

import com.toopher.openam.ToopherUtil;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;

/**
 * Request errors from API calls
 * 
 */
public class RequestError extends ClientProtocolException {

    public RequestError(String message) {
        super(message);
    }

    public RequestError(String message, Exception e) {
        super(message, e);
    }

    public RequestError(Exception e) {
        super(getSpecificExceptionMessage(e.getClass()), e);
    }

    private static String getSpecificExceptionMessage(Class c) {
        ToopherUtil.debug_message("TT RequestError.getSpecificExceptionMessage");
        if (ClientProtocolException.class.isAssignableFrom(c)) {
            return "Http protocol error";
        } else if (IOException.class.isAssignableFrom(c)) {
            return "Connection error";
        } else if (JSONException.class.isAssignableFrom(c)) {
            return "Unexpected response format";
        } else {
            return "Request error";
        }
    }

    private static final long serialVersionUID = -1479647692976296897L;
}
