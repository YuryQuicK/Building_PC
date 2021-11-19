let tooltip = document.querySelector('.tooltip');
let clicks = document.querySelectorAll('img');
let closeButton = document.querySelector('.close-button');
let opened = document.querySelector('.opened');
let sentValue = document.querySelector('.sendValue');

for (let click of clicks) {
    click.onclick = function () {
        tooltip.classList.add('opened');
    }
}

closeButton.onclick = function () {
    tooltip.classList.remove('opened');
}

sentValue.onclick = function () {
	fetch('./data')
	.then((response) => {
		return response.json()
	})
	.then((sentData) => {
		var values = sentValue
			.parentElement
			.getElementsByClassName('value');
		values[0].textContent = sentData["FirstValue"];
		values[1].textContent = sentData["SecondValue"];
	});
}
