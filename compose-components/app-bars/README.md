
## Top App Bar 

Don’t use curved shapes on top app bars as it implies that the container can expand upon interaction

Don't make a top app bar shorter than its default height by applying density

Don’t wrap text in a small, medium, or center-aligned top app bar

Don’t use more than three action icons

Contains a title and actions related to the current screen

Four types: center-aligned, small, medium, and large

On scroll, apply a container fill color to separate app bar from body content

Top app bars have the same width as the device window

Always use the default height of a top app bar.

For the compact window size class, the container occupies 100% of the screen width.

Upon scrolling, the top app bar can remain in place, or use a compress effect in which:
  Scrolling upward hides the top app bar
  Scrolling downward reveals the top app bar

Do Use the overflow menu to collapse less important actions

Do Use straight corners for top app bars

Do Default heights were chosen to ensure legibility of on-screen elements

Do If headline text is long, use a large top app bar and wrap the headline to two lines

## Bottom App Bar 

`Bottom app bars aren’t navigation bars`

`Navigation bars provide access to destinations in an app, whereas bottom app bars can contain both destinations and actions.`

Consider using a custom layout or other component if a bottom app bar doesn’t fulfill your screen’s needs, such as this set of filled buttons in a Calendar event invite

Bottom app bars provide access to up to four actions, including the floating action button (FAB).

Use bottom app bars to draw attention to important actions

Can contain up to four icon buttons and a floating action button (FAB)

Bottom app bar layout and contents can change on different screens of an app

Easy to reach on a mobile device

Don’t force actions into a bottom app bar. The icons in this Calendar event invite don’t clearly communicate their meaning.

Don't use a bottom app bar on screens with one or no actions (other than a FAB)

Do Use a bottom app bar to provide convenient access to actions

Do Use a snackbar to provide access to undo for destructive actions initiated from the bottom app bar
