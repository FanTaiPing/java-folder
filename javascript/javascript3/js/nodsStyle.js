var radioLabel = document.getElementById("radioLabel");
var content = document.getElementById("content");
var input = document.getElementsByTagName("input");

function img(index) {
    if (input[index].checked) {
        switch (index) {
            case 0:
                var image = document.getElementById("image");
                var image1 = document.getElementById("image1");
                if (image == null && image1 == null) {
                    var img = document.createElement("img");
                    img.setAttribute("src", "image/book_One.jpeg");
                    img.setAttribute("id", "image");
                    content.appendChild(img) + "<br>";
                } else {
                    image.parentNode.removeChild(image);
                    image1.parentNode.removeChild(image1);
                }
                break;

            case 1:
                var image1 = document.getElementById("image1");
                var image = document.getElementById("image");
                if (image1 == null || image == null) {
                    var img = document.createElement("img");
                    img.setAttribute("src", "image/book_Tow.jpg");
                    img.setAttribute("id", "image1");
                    content.appendChild(img);
                } else {
                    image1.parentNode.removeChild(image1);
                    // image.parentNode.removeChild(image);
                }

                break;
        }

    }

}

// function imgTow() {
//     var towImg = document.createElement("img");
//     towImg.setAttribute("src", "image/book_Tow.jpg");
//     content.appendChild(towImg);
//     changeImgTow();

// }