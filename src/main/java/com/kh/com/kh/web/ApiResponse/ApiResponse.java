package com.kh.com.kh.web.ApiResponse;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ClassUtils;

import java.util.Collection;
import java.util.Map;

@Slf4j@Getter@ToString
public class ApiResponse<T> {

    private Header header;
    private T body;
    private int totalCount;

    public ApiResponse(Header header, T body, int totalCount) {
        this.header = header;
        this.body = body;
        this.totalCount = totalCount;
    }
    @Getter@ToString
    private static class Header{
        private String rtcd;
        private String rtmsg;

        public Header(String rtcd, String rtmsg) {
            this.rtcd = rtcd;
            this.rtmsg = rtmsg;
        }
    }

    public static <T> ApiResponse<T> createApiResponse(String rtcd, String rtmsg, T body){
        int totalCount = 0;
        if(body != null){
            if(ClassUtils.isAssignable(Collection.class,body.getClass())){
                totalCount = ((Collection<?>)body).size();
            }else if(ClassUtils.isAssignable(Map.class,body.getClass())){
                totalCount = ((Map<?,?>)body).size();
            }else{
                totalCount = 1;
            }
        }
        return new ApiResponse<>(new Header(rtcd,rtmsg),body,totalCount);
    }
}
