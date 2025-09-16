# 🛡 CyberGuard - Your Digital Shield against Cyber Threats

CyberGuard is an Android application designed to empower users with the knowledge and tools needed to stay secure in the digital world. Built using **Kotlin** and **Firebase**, the app provides a holistic approach to cybersecurity awareness, threat detection, and safe browsing practices.

---

## 🚀 Features

### 🔔 Real-time Security Alerts  
Get notified about emerging cybersecurity threats and potential vulnerabilities.

### 🤖 Chatbot  
Ask security-related questions and receive instant, best-practice responses through an integrated chatbot.

### 📱 Device Security Checkup  
Analyze device configurations and identify potential weaknesses in settings.

### 🧼 Cyber Hygiene Tracker  
Track your daily digital hygiene activities and get reminders to maintain best practices.

### ❓ Cybersecurity Quiz Module  
Test your cybersecurity knowledge with interactive quizzes.

### 📰 Cybersecurity News Feed  
Stay up-to-date with the latest cyber threats and news from trusted sources.

### 💬 Terminal Emulator (Simulated)  
Practice and learn basic security commands in a simulated terminal environment.

---

## 🏗 Tech Stack
- **Frontend:** Kotlin (Android Studio)  
- **Backend:** Firebase Realtime Database  
- **Authentication:** Firebase (email-password based)  
- **Dev Tools:** Android Emulator, Firebase Console  

---

## 📁 Project Structure

```text
CyberGuard/
├── app/
│   └── src/
│       └── main/
│           ├── java/com/sanjana/cyberguard/
│           │   ├── RegisterActivity.kt
│           │   ├── LoginActivity.kt
│           │   ├── QuizActivity.kt
│           │   ├── ChatbotActivity.kt
│           │   ├── TerminalActivity.kt
│           │   ├── NewsActivity.kt
│           │   ├── SecurityCheckup.kt
│           │   ├── TrackerActivity.ktr
│           │   └── utils/
│           ├── res/
│           │   ├── layout/
│           │   ├── drawable/
│           │   └── values/
│           └── AndroidManifest.xml
├── screenshots/
│   ├── login.png
│   ├── chatbot.png
│   ├── quiz.png
│   └── tracker.png
├── google-services.json
├── build.gradle
├── app/build.gradle
├── README.md
└── LICENSE

## 🔧 Firebase Setup

1. Go to [Firebase Console](https://console.firebase.google.com/)  
2. Create a new project and enable **Realtime Database**  
3. Add your Android app to Firebase and download the `google-services.json` file  
4. Place the `google-services.json` file in your app's `/app` directory  
5. Update your `build.gradle` files accordingly  
6. Set up read/write rules for development in Firebase Realtime Database:

```json
{
  "rules": {
    ".read": true,
    ".write": true
  }
}
