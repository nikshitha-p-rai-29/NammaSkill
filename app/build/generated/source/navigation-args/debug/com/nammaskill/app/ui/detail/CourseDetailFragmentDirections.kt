package com.nammaskill.app.ui.detail

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.nammaskill.app.R

public class CourseDetailFragmentDirections private constructor() {
  public companion object {
    public fun actionDetailToApply(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detail_to_apply)

    public fun actionDetailToPing(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detail_to_ping)
  }
}
