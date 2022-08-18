<template>
<div v-if="streamManager">
	<ov-video :stream-manager="streamManager"/>
	<div><p>{{ nickName }}</p></div>
</div>
</template>

<script>
import axios from 'axios';
import OvVideo from './OvVideo';

export default {
	name: 'UserVideo',
	components: {
		OvVideo,
	},

	data() {
		return {
			nickName: '',
		};
	},

	props: {
		streamManager: Object,
	},

	create() {
		let access_token = localStorage.getItem('token')
		let config = {
			headers: {
				Authorization: access_token
			}
		}
		axios
			.get('https://i7d206.p.ssafy.io/api/users', config)
			.then(response => {
				console.log(response)
				let nickName = response.data.data.nickName
				this.clientData = nickName
			})

		// 원래 코드
		// clientData () {
		// 	const { clientData } = this.getConnectionData();
		// 	return clientData;
		// },
	},

	methods: {
		getConnectionData () {
			const { connection } = this.streamManager.stream;
			return JSON.parse(connection.data);
		},
	},
};
</script>