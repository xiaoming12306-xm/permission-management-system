package com.workflow.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.workflow.entity.WeChatMessage;
import com.workflow.entity.WeChatResponse;
import com.workflow.entity.WeChatTokenResponse;

@Service
public class WeChatService {

    @Value("${wechat.corpId}")
    private String corpId;

    @Value("${wechat.secret}")
    private String secret;

    @Value("${wechat.agentId}")
    private String agentId;

    private final RestTemplate restTemplate = new RestTemplate();

    // 获取AccessToken
    public String getAccessToken() {
        String url = UriComponentsBuilder.fromHttpUrl("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .queryParam("corpid", corpId)
                .queryParam("corpsecret", secret)
                .toUriString();

        WeChatTokenResponse response = restTemplate.getForObject(url, WeChatTokenResponse.class);
        if (response != null && response.getErrcode() == 0) {
            return response.getAccess_token();
        }
        throw new RuntimeException("获取AccessToken失败");
    }

    // 发送消息
    public void sendMessage(String userId, String content) {
        String accessToken = getAccessToken();
        String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + accessToken;

        WeChatMessage message = new WeChatMessage();
        message.setTouser(userId);
        message.setMsgtype("text");
        message.setAgentid(agentId);
        message.setText(new WeChatMessage.Text(content));

        WeChatResponse response = restTemplate.postForObject(url, message, WeChatResponse.class);
        if (response == null || response.getErrcode() != 0) {
            throw new RuntimeException("发送消息失败");
        }
    }

    // 获取用户信息
    public String getUserInfo(String userId) {
        String accessToken = getAccessToken();
        String url = UriComponentsBuilder.fromHttpUrl("https://qyapi.weixin.qq.com/cgi-bin/user/get")
                .queryParam("access_token", accessToken)
                .queryParam("userid", userId)
                .toUriString();

        String response = restTemplate.getForObject(url, String.class);
        return response;
    }
}