# 🔄 Redis Pub/Sub Demo (Java)

This is a simple **Redis-based Pub/Sub messaging system** implemented in **Java**. It demonstrates how publishers can send messages to specific channels (topics), and how subscribers can listen to only those they're interested in.

### ✅ Features
- Topic-based message publishing (e.g., "sports", "tech")
- Subscribers with configurable message limits
- Interactive CLI Publisher to simulate real-time input
- Clean unsubscribe behavior after a limit is reached

---

## 🧠 System Architecture

![Redis PubSub Flow](docs/redis-pubsub-flow.png)

---

## 🛠️ Tech Stack
- Java 11
- Jedis Redis Client
- Redis (localhost)
- Maven
- VSCode or IntelliJ (recommended)

---

## 🚀 How It Works

1. **Subscribers** are created with a max message limit and subscribed to specific channels.
2. **Publisher** (interactive CLI) publishes messages to channels.
3. **Redis Broker** ensures message delivery to all active subscribers on that channel.
4. After the subscriber hits their limit, they automatically unsubscribe.

---

## ▶️ Getting Started

### 1. Clone the Repo
```bash
git clone https://github.com/yourusername/redis-pubsub.git
cd redis-pubsub
mvn compile
mvn exec:java -Dexec.mainClass="com.example.App"
mvn exec:java -Dexec.mainClass="com.example.CLIPublisher"

```

MIT © 2025 MdJunaid
