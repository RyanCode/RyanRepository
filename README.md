# RyanRepository
1.服务器端(server)和客户端(client)分别生成自己的密钥对
2.server和client分别交换自己的公钥
3.client生成AES密钥(aesKey)
4.client使用自己的RSA私钥(privateKey)对请求明文数据(params)进行数字签名
5.将签名加入到请求参数中，然后转换为json格式
6.client使用aesKey对json数据进行加密得到密文(data)
7.client使用sever的RSA公钥对aesKey进行加密(encryptkey)
8.分别将data和encryptkey作为参数传输给服务器端
