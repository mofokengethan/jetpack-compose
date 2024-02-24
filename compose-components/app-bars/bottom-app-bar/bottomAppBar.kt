@Composable
fun BottomAppBarExample() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(Icons.Filled.Check, contentDescription = "Localized description")
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Mic,
                            contentDescription = "Localized description",
                        )
                    }
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            Icons.Filled.Image,
                            contentDescription = "Localized description",
                        )
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* do something */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, "Localized description")
                    }
                }
            )
        },
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "Example of a scaffold with a bottom app bar."
        )
    }
}
