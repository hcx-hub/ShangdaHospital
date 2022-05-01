<template>
	<view>
		<u-navbar :is-back="false" title="我" :background="background"></u-navbar>
		<view style="display: flex;margin: 30upx 25upx;">
			<view style="flex-direction: row; ">
				<u-image width="180upx" height="180rpx" shape="circle" style="margin-left: 20upx;" :src="imgsrc" />
			</view>
			<view style="margin: 20upx 40upx;">
				<view style="font-size:40upx;color: #333333;">
					{{patientname}}
				</view>
				<view style="margin-top: 50upx;font-size: 30upx;color: #999999;">
					用户名:{{username}}
				</view>
			</view>

		</view>
		<u-cell-group style="margin-top:50upx;">
			<u-cell-item icon="setting-fill" title="修改名称"></u-cell-item>
			<u-cell-item icon="lock-fill" title="修改密码"></u-cell-item>
		</u-cell-group>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				background: {
					backgroundColor: '#eeeeee',

				},
				imgsrc: '',
				sex:'',
				username: '',
				patientname:''
			}
		},
		created() {
		    this.sex=JSON.parse(sessionStorage.getItem('user')).sex.toString()
			this.username= JSON.parse(sessionStorage.getItem('user')).username.toString(),
			this.patientname=JSON.parse(sessionStorage.getItem('user')).patientName.toString()
			this.load()
			console.log(JSON.parse(sessionStorage.getItem('user')).sex.toString())
			console.log(JSON.parse(sessionStorage.getItem('user')).username.toString())
			console.log(JSON.parse(sessionStorage.getItem('user')).patientName.toString())
			
		  },
		methods: {
			load() {
				//获取用户名、头像等信息
				//如果判断为男生则img设为男生的头像
				if (this.sex==='男') {
					this.imgsrc = '../../static/icons/man.png'
				} else {
					this.imgsrc = '../../static/icons/female.png'
				}

			}
		}
	}
</script>

<style >
	
</style>
