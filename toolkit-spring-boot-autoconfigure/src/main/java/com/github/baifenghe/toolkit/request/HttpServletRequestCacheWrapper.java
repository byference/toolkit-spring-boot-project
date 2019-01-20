package com.github.baifenghe.toolkit.request;

import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * 重写 HttpServletRequestWrapper
 *
 * @author bfh
 * @since 2019/01/06
 */
public class HttpServletRequestCacheWrapper extends HttpServletRequestWrapper {

    private byte[] body;
    private ServletCacheInputStream servletCacheInputStream;

    public HttpServletRequestCacheWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.body = IOUtils.toByteArray(request.getInputStream());
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.body != null ? this.body : new byte[0]);
        this.servletCacheInputStream = new ServletCacheInputStream(byteArrayInputStream);
    }

    public byte[] getBody() {
        return body;
    }

    @Override
    public ServletInputStream getInputStream() {
        return this.servletCacheInputStream;
    }

    @Override
    public BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(this.servletCacheInputStream));
    }

    @AllArgsConstructor
    private static class ServletCacheInputStream extends ServletInputStream {

        private ByteArrayInputStream byteArrayInputStream;

        @Override
        public int read() {
            return byteArrayInputStream.read();
        }

        @Override
        public boolean isFinished() {
            return byteArrayInputStream.available() == 0;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener readListener) {}

    }


}
