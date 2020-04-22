package com.ryan.springbootvue.service.token;

/**
 * @Author Ryan
 * @Date 2020/4/22 20:18
 * version 1.0
 */
public interface GenAndVerTokenService {
    //公钥
    public static final String PUBLIC_KEY="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAJErkEY8AnjbwReLpu0d+CcGTlPoHAzS7X3JEj48gz1SvV8486jG3Lqvhca1oq8vtZxCMjWL4g8iMcrgovMCV2cCAwEAAQ==";
    //私钥
    public static final String PRIVATE_KEY="MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAkSuQRjwCeNvBF4um7R34JwZOU+gcDNLtfckSPjyDPVK9XzjzqMbcuq+FxrWiry+1nEIyNYviDyIxyuCi8wJXZwIDAQABAkAJJxn9k6MEQ7a06VUo9g7DRx6BI81A8buPhrHjwqTzpL8OtgXVB/hhZ0PfQWSgOYYOcs6umBvL2Ttf2WmmdtdhAiEA6ia/sbafxY8pcahTxP2IRfUDSYkfcG30xAD8+k1tWw0CIQCet0qiKM9GK8skUZpgcZU0LYL9Z1syMJpFU6EmTNTPQwIhANy5iEzrPbOLH+NPbSAua06fB+lDBMsELA60a8U8RdDlAiB8rYuJWvmIK/rGKvxUaqVEecP+f+SZxqhJcWqUBaLetQIgeuJLLFFKXcEQJzS5mmc7h/VXL9aMjljECjqG9lxaueI=";

    String genToken(String source) throws Exception;

    String verToken(String cryptograph) throws Exception;
}
