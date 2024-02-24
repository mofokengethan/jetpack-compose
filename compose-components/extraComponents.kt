@Composable
fun TabRowExample(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color = TabRowDefaults.primaryContainerColor,
    contentColor: Color = TabRowDefaults.primaryContentColor,
    indicator: @Composable (tabPositions: List<TabPosition>) -> Unit = @Composable { tabPositions ->
        if (selectedTabIndex < tabPositions.size) {
            TabRowDefaults.SecondaryIndicator(
                Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
            )
        }
    },
    divider: @Composable () -> Unit = @Composable {
        HorizontalDivider()
    },
    tabs: @Composable () -> Unit
): Unit

@Composable
fun BadgeExample(
    modifier: Modifier = Modifier,
    containerColor: Color = BadgeDefaults.containerColor,
    contentColor: Color = contentColorFor(containerColor),
    content: (@Composable RowScope.() -> Unit)? = null
): Unit

@Composable 
fun CheckboxExample() {
  val checkedState = remember { mutableStateOf(true) }
  Checkbox(
      checked = checkedState.value,
      onCheckedChange = { checkedState.value = it }
  )
}

@Composable
fun RadioButtonExample(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: RadioButtonColors = RadioButtonDefaults.colors(),
    interactionSource: MutableInteractionSource? = null
): Unit

@Composable 
fun CheckboxExampleWithTextExample() {
  val (checkedState, onStateChange) = remember { mutableStateOf(true) }
  Row(
      Modifier
          .fillMaxWidth()
          .height(56.dp)
          .toggleable(
              value = checkedState,
              onValueChange = { onStateChange(!checkedState) },
              role = Role.Checkbox
          )
          .padding(horizontal = 16.dp),
      verticalAlignment = Alignment.CenterVertically
  ) {
      Checkbox(
          checked = checkedState,
          onCheckedChange = null // null recommended for accessibility with screenreaders
      )
      Text(
          text = "Option selection",
          style = MaterialTheme.typography.bodyLarge,
          modifier = Modifier.padding(start = 16.dp)
      )
  }
}

@ExperimentalMaterial3Api
@Composable
fun DatePickerExample(
    state: DatePickerState,
    modifier: Modifier = Modifier,
    dateFormatter: DatePickerFormatter = remember { DatePickerDefaults.dateFormatter() },
    title: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerTitle(
            displayMode = state.displayMode,
            modifier = Modifier.padding(DatePickerTitlePadding)
        )
    },
    headline: (@Composable () -> Unit)? = {
        DatePickerDefaults.DatePickerHeadline(
            selectedDateMillis = state.selectedDateMillis,
            displayMode = state.displayMode,
            dateFormatter = dateFormatter,
            modifier = Modifier.padding(DatePickerHeadlinePadding)
        )
    },
    showModeToggle: Boolean = true,
    colors: DatePickerColors = DatePickerDefaults.colors()
): Unit

@Composable
fun HorizontalDividerExample(
    modifier: Modifier = Modifier,
    thickness: Dp = DividerDefaults.Thickness,
    color: Color = DividerDefaults.color
): Unit

@Composable
fun VerticalDividerExample(
    modifier: Modifier = Modifier,
    thickness: Dp = DividerDefaults.Thickness,
    color: Color = DividerDefaults.color
): Unit

@Composable
fun NavigationBarExample(
    modifier: Modifier = Modifier,
    containerColor: Color = NavigationBarDefaults.containerColor,
    contentColor: Color = MaterialTheme.colorScheme.contentColorFor(containerColor),
    tonalElevation: Dp = NavigationBarDefaults.Elevation,
    windowInsets: WindowInsets = NavigationBarDefaults.windowInsets,
    content: @Composable RowScope.() -> Unit
): Unit

// Row scope means the composable / view needs to be inside the scope... of a row 
@Composable
fun RowScope.NavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: (@Composable () -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
    colors: NavigationBarItemColors = NavigationBarItemDefaults.colors(),
    interactionSource: MutableInteractionSource? = null
): Unit

