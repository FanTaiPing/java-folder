function table() {
    for (var i = 1; i <= 9; i++) {
        for (var j = 1; j <= i; j++) {
            var product = i * j;
            document.write(`${j} * ${i} = ${product}&nbsp;&nbsp;&nbsp;&nbsp;`);
        }
        document.write(`<br>`);
    }
}