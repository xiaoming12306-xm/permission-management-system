package com.flow.platform.service.impl;

import com.flow.platform.service.WeChatService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeChatServiceImpl implements WeChatService {

    @Value("${wechat.corpId}")
    private String corpId;

    @Value("${wechat.secret}")
    private String secret;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void sendMessage(String userId, String message) {
        String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + getAccessToken();
        String requestBody = String.format(
            "{\"touser\":\"%s\",\"msgtype\":\"text\",\"agentid\":1,\"text\":{\"content\":\"%s\"}}",
            userId, message);
        restTemplate.postForObject(url, requestBody, String.class);
    }

    @Override
    public void sendApprovalNotification(Long userId, String formId) {

    }

    private String getAccessToken() {
        String url = String.format("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=%s&corpsecret=%s", corpId, secret);
        return restTemplate.getForObject(url, String.class);
    }
}