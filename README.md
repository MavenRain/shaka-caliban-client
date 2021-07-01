# shaka-caliban-client

## To Develop:
1. Launch a sbt session with `sbt`.
2. In the sbt console, run `~fastLinkJS`, which incrementally recompiles on save.
3. Open `index.html` in your browser, or optionally run something like [`serve`](https://github.com/AugustNagro/serve) in a new terminal tab for hot-reload.

## To Deploy
1. Run `fullLinkJS`.
2. Copy `prod.index.html` to `index.html` on your server.
3. Copy `target/scala-3.0.0/shaka-caliban-client-fastopt/main.js` to `shaka-caliban-client.js` on your server.
4. Redeploy the server.