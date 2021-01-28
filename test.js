const https = require("https");
https.get("https://api.weixin.qq.com/cgi-bin/user/get?access_token=41_n_KWstmA6a9hjau7OlGfsr-KXhW5r99TDFhOfVLCnXjNS1A2PLCXbl3xq_xwMysXx9i0wkBfX68TOk8AcIHmaJ2ZPcnyWknAo6EvqGYjuYft6iy_d-Ye5Ro3Ca4C4YbKb6dQXXDyt4nRpoP_ANKgAIANAX&next_openid=NEXT_OPENID2", res => {
    res.setEncoding("utf8");
    let body = "";
    res.on("data", data => {
        body += data;
    });
    res.on("end", () => {
        console.log(body);
    });
});