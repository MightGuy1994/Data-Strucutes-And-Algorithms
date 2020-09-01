# Design YouTube


## Functional requirements
	1. Upload Video
	2. Search Video
	3. view Video
	4. add/view comments
	5. record stats of videos
## Non Functional requirements
	1. Reliable - Once uploaded cannot be lost - (multiple copies)
	2. Available - Able to see the video always
	3. real time experience - put video near to user

## System Api's
	1. uploadVideo(key, video contents, tags, description, title, category_id) - Returns HTTP 
	2. searchVideo(key, search_query, max_videos_to_return, page_token) - json list of vidoes
	3. streamVideo(key, video_id, offset,codec, resolution) - stream a video chunk from offset

## High Level Design
	1. Processing queue - each uploaed video goes to a queue to be dequeued later for encoding, tumbnail generation, storage
	2. Encoder - To encode each uploaded video into multiple formats
	3. Tumbnails generator - To generate a tumbnail for each video
	4. Video and tumbnail generator - to store video and tumbnail files in some distributed storage
	5. User database - To store user information e.g. name, email, address etc
	6. Video metadata storage - A metadata database to store all the information about vidoes like title, file path in the system, uploading user, total views, likes, dislikes etc.

## Database design
	1. Video metadata - Video id, title, description, size, tumbnails, link, upload_user, totalViews, totalLikes, totalDisLikes
	2. Comment - comment_id, video_id, user_id, content
	3. User data storage - Userid, name, email etc.


## Detailed Component design
	1. 