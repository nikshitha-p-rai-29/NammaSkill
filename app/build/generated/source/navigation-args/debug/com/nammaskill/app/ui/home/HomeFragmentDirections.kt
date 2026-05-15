package com.nammaskill.app.ui.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nammaskill.app.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeToDetail(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_detail)

    public fun actionHomeToApply(): NavDirections =
        ActionOnlyNavDirections(R.id.action_home_to_apply)
  }
}
