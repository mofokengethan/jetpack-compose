@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun SliderAdvancedExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 3,
            valueRange = 0f..50f
        )
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column {
        RangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
        )
        Text(text = sliderPosition.toString())
    }
}
