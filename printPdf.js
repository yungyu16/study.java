function appendScript(url) {
    return new Promise((resolve, reject) => {
        $.getScript(url, (_, code, jqxhr) => {
            if (jqxhr.status === 200) {
                resolve(_);
            } else {
                console.log("加载js脚本失败：", url, status);
                reject(status)
            }
        });
    })
}

appendScript('https://cdn.bootcss.com/html2canvas/0.5.0-beta4/html2canvas.js')
    .then(appendScript('https://cdn.staticfile.org/jspdf/1.5.3/jspdf.debug.js'))
    .then(() => {
        html2canvas(document.body, {
            onrendered: function (canvas) {
                //返回图片dataURL，参数：图片格式和清晰度(0-1)
                let pageData = canvas.toDataURL('image/jpeg', 1.0);
                //方向默认竖直，尺寸ponits，格式a4[595.28,841.89]
                let pdf = new jsPDF('', 'pt', 'a4');
                //addImage后两个参数控制添加图片的尺寸，此处将页面高度按照a4纸宽高比列进行压缩
                pdf.addImage(pageData, 'JPEG', 0, 0, 595.28, 592.28 / canvas.width * canvas.height);
                pdf.save(`${document.title}.pdf`);
            }
        })
    })