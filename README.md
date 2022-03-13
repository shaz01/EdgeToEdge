# EdgeToEdge
Utility object that allows you to fix padding/margin issues in your fragments.
 
Example:
```
EdgeToEdge.fixPadding(binding.navigationRailView, left = true, top = true) //called in onCreate of Activity
```

```
val bottomActive = requireContext().resources.getBoolean(R.bool.bottom_margin_active) //custom bool attribute, true if width > 600dp
EdgeToEdge.fixMargin(binding.deleteAllButton, right = true, bottom = bottomActive) //called in onCreateView of Fragment
```
