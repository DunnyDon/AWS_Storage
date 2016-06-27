$path = "C:\Users\cdonohue\Desktop\Temp"
function upload ($directory) {
	ForEach ($file in Get-ChildItem $directory){
		if((Get-Item $file.fullname) -is [System.IO.DirectoryInfo]){
			Write-S3Object -BucketName amazonamibucketstorage -KeyPrefix $File -Folder $file.fullname -Recurse
		}
		else{
			#Write-S3Object -BucketName amazonamibucketstorage -File $file.fullname
		}
	}
 }
 
 
 upload $path