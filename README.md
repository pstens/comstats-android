# Comstats for Android

Sample application for toying around with clean architecture.
This uses my [comstats-api](https://comstats-api.pstens.now.sh) to fetch the current rankings of all player in a Comunio-Community.

Currently, this just uses an in-memory cache for downloaded stats but will soon be extended to persist data across app restarts.

## TODO
- [ ] Implement LocalDataSource using ROOM for
- [ ] Add DetailScreen for each member showing his squad + points of each player
- [ ] Make this configurable for other Comunio-Communities
