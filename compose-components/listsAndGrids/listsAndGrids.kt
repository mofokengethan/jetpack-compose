@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text(
            "Text",
            Modifier.constrainAs(text) {
                top.linkTo(button.bottom, margin = 16.dp)
            }
        )
    }
}

/*
* Guidelines are small visual helpers to design layouts with. Composables can be 
* constrained to a guideline. Guidelines are useful for positioning elements at a
* certain dp or percentage inside the parent composable.

* There are two different kinds of guidelines, vertical and horizontal. The two 
* horizontal ones are top and bottom, and the two vertical are start and end.

* Note: Consider using the Spacer composable to achieve a similar effect with 
* Rows and Columns.
*/
ConstraintLayout {
    // Create guideline from the start of the parent at 10% the width of the Composable
    val startGuideline = createGuidelineFromStart(0.1f)
    // Create guideline from the end of the parent at 10% the width of the Composable
    val endGuideline = createGuidelineFromEnd(0.1f)
    //  Create guideline from 16 dp from the top of the parent
    val topGuideline = createGuidelineFromTop(16.dp)
    //  Create guideline from 16 dp from the bottom of the parent
    val bottomGuideline = createGuidelineFromBottom(16.dp)
}

/*
* Barriers reference multiple composables to create a virtual guideline based 
* on the most extreme widget on the specified side.

* To create a barrier, use createTopBarrier() (or: createBottomBarrier(), 
* createEndBarrier(), createStartBarrier()), and provide the references that 
* should make up the barrier.
*/
ConstraintLayout {
    val constraintSet = ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        val topBarrier = createTopBarrier(button, text)
    }
}

/*
* Chains provide group-like behavior in a single axis (horizontally or 
* vertically) . The other axis can be constrained independently.
*/
ConstraintLayout {
    val constraintSet = ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")

        val verticalChain = createVerticalChain(button, text, chainStyle = ChainStyle.Spread)
        val horizontalChain = createHorizontalChain(button, text)
    }
}

@Composable
fun MessageList(messages: List<Message>) {
    Column {
        messages.forEach { message ->
            MessageRow(message)
        }
    }
}

@Composable 
fun LazyColumnExample6() {
  LazyColumn {
      items(books, key = { it.id }) {
          val rememberedValue = rememberSaveable {
              Random.nextInt()
          }
      }
  }
}

@Composable 
fun LazyColumnExample5() {
  LazyColumn {
      items(books, key = {
          // primitives, enums, Parcelable, etc.
      }) {
          // ...
      }
  }
}

@Composable 
fun LazyColumnExample4() {
  LazyColumn {
      items(books, key = { it.id }) {
          val rememberedValue = remember {
              Random.nextInt()
          }
      }
  }
}


@Composable
fun LazyColumnExample3() {
  LazyColumn {
      items(
          items = messages,
          key = { message ->
              // Return a stable + unique key for the item
              message.id
          }
      ) { message ->
          MessageRow(message)
      }
  }
}


@Composable 
fun LazyRowExample() {
  LazyRow(
    horizontalArrangement = Arrangement.spacedBy(4.dp),
  ) {
      // ...
  }
}

@Composable 
fun LazyColumnExample() {
  LazyColumn(
    verticalArrangement = Arrangement.spacedBy(4.dp)
  ) {
    // Add a single item
    item {
        Text(text = "First item")
    }
  
    // Add 5 items
    items(5) { index ->
        Text(text = "Item: $index")
    }
  
    // Add another single item
    item {
        Text(text = "Last item")
    }
  }
}

@Composable 
fun LazyColumnExample2() {
  /**
 * import androidx.compose.foundation.lazy.items
 */
  LazyColumn(
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
  ) {
      items(messages) { message ->
          MessageRow(message)
      }
  }
}

@Composable 
fun LazyVerticalGridExample() {
  LazyVerticalGrid(
      columns = GridCells.Adaptive(minSize = 128.dp)
  ) {
      items(photos) { photo ->
          PhotoItem(photo)
      }
  }
}

@Composable 
fun LazyVerticalGridExample() {
  LazyVerticalGrid(
    columns = GridCells.Adaptive(minSize = 30.dp)
  ) {
      item(span = {
          // LazyGridItemSpanScope:
          // maxLineSpan
          GridItemSpan(maxLineSpan)
      }) {
          CategoryCard("Fruits")
      }
      // ...
  }
}

@Composable 
fun LazyVerticalGridExample2() {
  LazyVerticalStaggeredGrid(
      columns = StaggeredGridCells.Adaptive(200.dp),
      verticalItemSpacing = 4.dp,
      horizontalArrangement = Arrangement.spacedBy(4.dp),
      content = {
          items(randomSizedPhotos) { photo ->
              AsyncImage(
                  model = photo,
                  contentScale = ContentScale.Crop,
                  contentDescription = null,
                  modifier = Modifier.fillMaxWidth().wrapContentHeight()
              )
          }
      },
      modifier = Modifier.fillMaxSize()
  )
}

@Composable 
fun LazyVerticalGridExmaple3() {
  LazyVerticalGrid(
      columns = GridCells.Fixed(2),
      verticalArrangement = Arrangement.spacedBy(16.dp),
      horizontalArrangement = Arrangement.spacedBy(16.dp)
  ) {
      items(photos) { item ->
          PhotoItem(item)
      }
  }
}

@Composable 
fun LazyVerticalStaggeredGridExample() {
  LazyVerticalStaggeredGrid(
      columns = StaggeredGridCells.Fixed(3),
      verticalItemSpacing = 4.dp,
      horizontalArrangement = Arrangement.spacedBy(4.dp),
      content = {
          items(randomSizedPhotos) { photo ->
              AsyncImage(
                  model = photo,
                  contentScale = ContentScale.Crop,
                  contentDescription = null,
                  modifier = Modifier.fillMaxWidth().wrapContentHeight()
              )
          }
      },
      modifier = Modifier.fillMaxSize()
  )
}

// Item Animations 

@Composable 
fun ItemAnimationExample() {
  LazyColumn {
      items(books, key = { it.id }) {
          Row(Modifier.animateItemPlacement()) {
              // ...
          }
      }
  }
}

@Composable 
fun ItemAnimationExample() { 
  LazyColumn {
      items(books, key = { it.id }) {
          Row(
              Modifier.animateItemPlacement(
                  tween(durationMillis = 250)
              )
          ) {
              // ...
          }
      }
  }
}

// Scroll position 
@Composable
fun MessageListExample2(messages: List<Message>) {
    // Remember our own LazyListState
    val listState = rememberLazyListState()

    // Provide it to LazyColumn
    LazyColumn(state = listState) {
        // ...
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MessageListExample3(messages: List<Message>) {
    Box {
        val listState = rememberLazyListState()

        LazyColumn(state = listState) {
            // ...
        }

        // Show the button if the first visible item is past
        // the first item. We use a remembered derived state to
        // minimize unnecessary compositions
        val showButton by remember {
            derivedStateOf {
                listState.firstVisibleItemIndex > 0
            }
        }

        AnimatedVisibility(visible = showButton) {
            ScrollToTopButton()
        }
    }
}

/*
* Scenarios where the event does not need to be handled in the same composition. 
* A common example of this is sending an analytics event once the user has scrolled 
* past a certain point. To handle this efficiently, we can use a snapshotFlow()
*/
@Composable 
fun SnapShotFlowExample() {
  val listState = rememberLazyListState()

  LazyColumn(state = listState) {
      // ...
  }
  
  LaunchedEffect(listState) {
      snapshotFlow { listState.firstVisibleItemIndex }
          .map { index -> index > 0 }
          .distinctUntilChanged()
          .filter { it }
          .collect {
              MyAnalyticsService.sendScrolledPastFirstItemEvent()
          }
  }
}

/*
* As well as reacting to scroll position, it’s also useful for apps to be able to 
* control the scroll position too. LazyListState supports this via the 
* scrollToItem() function, which ‘immediately’ snaps the scroll position, and 
* animateScrollToItem() which scrolls using an animation (also known as a smooth 
* scroll)
* 
* Note: Both scrollToItem() and animateScrollToItem() are suspending functions, 
* which means that we need to invoke them in a coroutine. See our coroutines 
* documentation for more information on how to do that in Compose.
* 
* Beware of putting multiple elements in one item
* https://developer.android.com/jetpack/compose/lists#multiple-elements-one-item
*/
@Composable
fun ScrollToExample(messages: List<Message>) {
    val listState = rememberLazyListState()
    // Remember a CoroutineScope to be able to launch
    val coroutineScope = rememberCoroutineScope()

    LazyColumn(state = listState) {
        // items 
        items(data) { item ->
            PhotoItem(item)
        }
        // Scroll to action 
        item {
        ScrollToTopButton(
              onClick = {
                  coroutineScope.launch {
                      // Animate scroll to the first item
                      listState.animateScrollToItem(index = 0)
                  }
              }
          )
        }
        // Footer
        item {
            Footer()
        }
    }
}








