const fetch = require("node-fetch");

postUsers = async () => {
	let randomStringForName = Math.random().toString(36).substring(7);

    const settings = {
        method: 'POST',
        headers: {
            Accept: 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
							  "age": 10,
							  "name": randomStringForName
							 })
    };
    try {
        const fetchResponse = await fetch('http://localhost:8080/users', settings);
        const data = await fetchResponse.json();
        console.log(data);
        return data;
    } catch (e) {
    	console.log(e)
        return e;
    }    

}


for (var i = 0; i < 2000; i++) {
	getDevices();
}

for (var i = 0; i < 2000; i++) {
	getDevices();
}

for (var i = 0; i < 2000; i++) {
	getDevices();
}

for (var i = 0; i < 2000; i++) {
	getDevices();
}

for (var i = 0; i < 2000; i++) {
	getDevices();
}

for (var i = 0; i < 2000; i++) {
	getDevices();
}

//getDevices();
