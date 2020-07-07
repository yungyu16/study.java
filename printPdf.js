function appendScript(url) {
    return new Promise((resolve, reject) => {
        $.getScript(url, (a, b, jqxhr) => {
            if (jqxhr.status === 200) {
                resolve(a);
            } else {
                console.error("加载js脚本失败：", url, jqxhr.status);
                reject(jqxhr.status)
            }
        });
    })
}

(window.jQuery ? Promise.resolve() : Promise.reject('当前页面环境没有jQuery'))
    .then(() => appendScript('https://cdn.bootcss.com/html2canvas/0.5.0-beta4/html2canvas.js'))
    .then(() => appendScript('https://cdn.staticfile.org/jspdf/1.5.3/jspdf.debug.js'))
    .then(() => html2canvas(document.body, {
        onrendered: function (canvas) {
            let pageData = canvas.toDataURL('image/jpeg', 1.0);
            let pdf = new jsPDF('', 'pt', 'a4');
            pdf.addImage(pageData, 'JPEG', 0, 0, 595.28, 592.28 / canvas.width * canvas.height);
            pdf.save(`${document.title}.pdf`);
            console.log('打印完成')
        }
    })).catch(err => console.error('打印失败', err));