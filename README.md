# Utada Info API 🎵

Welcome to the Utada Info API! This API was created to study Spring AI, it returns various information about her career, albums, singles, and live performances. 🌟
## Built with Inspiration from [Michelli Brito](https://github.com/MichelliBrito)'s Spring AI Video
This application was built based on Michelli Brito's Spring AI tutorial, which you can watch [here](https://www.youtube.com/watch?v=NscHAlj-yQ0&ab_channel=MichelliBrito). Thank you, Michelli, for the fantastic tutorial! 🙌
## Endpoints 🚀

### 1. About Utada Hikaru ℹ️
- **Endpoint:** `/utada/about`
- **Description:** Provides a summary about Utada Hikaru.
- **Parameters:** `message` (optional) - A brief description request (default: "Send a brief description about Utada Hikaru and the official website").

### 2. Top Selling Albums 💿
- **Endpoint:** `/utada/top-albums`
- **Description:** Lists the best selling albums by Utada Hikaru.
- **Parameters:** `message` (optional) - A request for the best selling albums (default: "What are the best selling albums from Utada Hikaru?").

### 3. Single or Album Information 🎶
- **Endpoint:** `/utada/title-info`
- **Description:** Provides a summary about a single or album by Utada Hikaru and lists all the tracks.
- **Parameters:** 
  - `type` - Type of release (Single or Album).
  - `title` (optional) - Title of the single or album (default: "First Love").

### 4. Track Translation 📝
- **Endpoint:** `/utada/track-translation`
- **Description:** Should translate the lyrics of a track by Utada Hikaru from romaji to English. But it doesn't work very well because the OpenAI API says it violates the Terms Of Use somehow.
- **Parameters:** `track` (optional) - Title of the track (default: "First Love").

### 5. Live Performances (Asynchronous) 🎤
- **Endpoint:** `/utada/live-concerts-async`
- **Description:** Lists Utada Hikaru's live performances asynchronously. Returns a fragmented with continuous stream of responses.
- **Parameters:** `message` (optional) - A request for the list of live performances (default: "List all live performances from Utada Hikaru, including dates and locations").

## Technologies Used 💻
- **Java** ☕
- **Spring Boot**: Framework for building the API.
- **OpenAI Chat Client**: Integration for AI-powered responses.
- **Swagger**: Documentation and testing tool for the API endpoints.
- **Reactor Core**: Library for handling asynchronous streams of data.

## Usage 🛠️
To use the API, simply make HTTP GET requests to the respective endpoints with the required parameters. You'll receive JSON responses containing the requested information.

## Feedback and Contributions 📫
Your feedback is valuable! If you have any suggestions, encounter issues, or want to contribute to the project, feel free to open an issue or submit a pull request on GitHub.
