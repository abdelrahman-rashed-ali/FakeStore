
# 🛒 FakeStore Product Viewer

An Android application built with **Jetpack Compose** and **Clean Architecture** that fetches and displays products from the [FakeStore API](https://api.escuelajs.co/api/v1/products).  
This project demonstrates **MVVM**, **Retrofit (Gson)**, **Coroutines**, and **Navigation Component** in a modern Compose-based app.

---

## 🚀 Features

- ✅ Fetches real products from FakeStore API  
- ✅ Displays products in a **scrollable LazyColumn**  
- ✅ Product details screen with **image, price, and description**  
- ✅ Clean Architecture with **Domain, Data, and Presentation layers**  
- ✅ Handles **loading state, error handling, and navigation**  
- ✅ Uses **Google Gson** for JSON parsing  
- ✅ Material 3 UI with Compose

---

## 🛠️ Tech Stack

- **Kotlin** – Main programming language  
- **Jetpack Compose** – UI framework  
- **MVVM Architecture** – Separation of concerns  
- **Coroutines & Flow** – Asynchronous operations  
- **Retrofit + Gson** – Networking & JSON parsing  
- **StateFlow** – Reactive UI state management  
- **Coil** – Image loading  
- **Navigation Component** – Screen navigation

---

## 📂 Project Structure

```
com.example.fakestore
│
├── data
│   ├── remote        # Retrofit API & Network setup
│   ├── repository    # ProductRepository implementation
│
├── domain
│   ├── model         # Product data models
│   ├── usecase       # GetProductsUseCase
│
├── presentation
│   ├── home          # HomeScreen UI + ViewModel
│   ├── details       # DetailScreen UI
│   ├── components    # Reusable UI components
│
├── util              # ResultWrapper for success/error/loading
└── MainActivity.kt   # App entry point
```

---

## 📦 API Used

- **Base URL:** `https://api.escuelajs.co/api/v1/`
- **Endpoint:** `/products`  
Example response:

```json
[
  {
    "id": 1,
    "title": "Smartphone",
    "price": 299,
    "description": "Latest 5G smartphone",
    "images": ["https://example.com/image.png"]
  }
]
```

---

## 🔧 Setup & Installation

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/fakestore-product-viewer.git
   ```
2. Open the project in **Android Studio**.
3. Add the following dependency in `app/build.gradle`:
   ```gradle
   implementation("com.squareup.retrofit2:converter-gson:2.11.0")
   implementation("io.coil-kt:coil-compose:2.6.0")
   ```
4. Add Internet permission in `AndroidManifest.xml`:
   ```xml
   <uses-permission android:name="android.permission.INTERNET"/>
   ```
5. Build and run the app on an emulator or real device.

---

## 🖼️ Screenshots

| Home Screen | Detail Screen |
|-------------|---------------|
| ![Home](https://via.placeholder.com/200x400?text=Home+Screen) | ![Detail](https://via.placeholder.com/200x400?text=Detail+Screen) |

---

## ✅ Future Improvements

- Implement **Hilt Dependency Injection**
- Add **Search and Filter** for products
- Offline caching using **Room database**
- Unit tests for **UseCases and ViewModels**

---

## 🤝 Contributing

Contributions are welcome! Feel free to **fork this repo** and submit a pull request.

---

## 📜 License

This project is licensed under the **MIT License** – see the [LICENSE](LICENSE) file for details.
