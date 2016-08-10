/**
 * Created by Laz on 10.08.2016.
 */

document.getElementById('changeColorButton').onclick = changeColor;

function changeColor() {
    if (document.bgColor == "green") {
        document.bgColor = "red";
    } else if (document.bgColor == "red") {
        document.bgColor = "blue";
    } else {
        document.bgColor = "green"
    }
}
