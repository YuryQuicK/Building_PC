let tooltip = document.querySelector('.tooltip');
let clicks = document.querySelectorAll('img');
let closeButton = document.querySelector('.close-button');
let opened = document.querySelector('.opened');

for (let click of clicks) {
    click.onclick = function () {
        tooltip.classList.add('opened');
    }
}

closeButton.onclick = function () {
    tooltip.classList.remove('opened');
}
