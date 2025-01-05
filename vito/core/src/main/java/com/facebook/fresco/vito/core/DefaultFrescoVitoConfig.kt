/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.fresco.vito.core

import com.facebook.common.callercontext.ContextChain
import com.facebook.common.internal.Supplier
import com.facebook.common.internal.Suppliers

open class DefaultFrescoVitoConfig
@JvmOverloads
constructor(override val prefetchConfig: PrefetchConfig = DefaultPrefetchConfig()) :
    FrescoVitoConfig {

  override fun submitFetchOnBgThread(): Boolean = true

  override fun useBindOnly(): Boolean = false

  override fun useNewReleaseCallback(): Boolean = false

  override fun useNativeRounding(): Supplier<Boolean>? = Suppliers.BOOLEAN_TRUE

  override fun layoutPrefetchingEnabled(callerContext: Any?): Boolean = false

  override fun useSmartPropertyDiffing(): Boolean = false

  override fun onlyStopAnimationWhenAutoPlayEnabled(): Boolean = true

  override fun fastPathForEmptyRequests(): Boolean = false

  override fun enableWindowWideColorGamut(): Boolean = false

  override fun handleImageResultInBackground(): Boolean = false

  override fun useIntermediateImagesAsPlaceholder(): Boolean = false

  override fun fallbackToDefaultImageOptions(): Boolean = false

  override fun experimentalDynamicSizeVito2(): Boolean = false

  override fun experimentalDynamicSizeWithCacheFallbackVito2(): Boolean = false

  override fun experimentalDynamicSizeOnPrepareMainThreadVito2(): Boolean = false

  override fun experimentalDynamicSizeDiskCacheCheckTimeoutMs(): Long = 0

  override fun experimentalDynamicSizeUseSfOnDiskCacheTimeout(): Boolean = false

  override fun isAppStarting(): Boolean = false

  override fun experimentalDynamicSizeDisableWhenAppIsStarting(): Boolean = false

  override fun experimentalDynamicSizeCheckIfProductIsEnabled(): Boolean = false

  override fun experimentalDynamicSizeIsProductEnabled(
      callerContext: Any?,
      contextChain: ContextChain?
  ): Boolean = true

  override fun experimentalResetVitoImageRequestListener() = false

  override fun experimentalResetLocalVitoImageRequestListener() = false

  override fun experimentalResetLocalImagePerfStateListener() = false

  override fun experimentalResetControllerListener2() = false

  open class DefaultPrefetchConfig : PrefetchConfig {
    override fun prefetchInOnPrepare(): Boolean = true

    override fun prefetchInOnBoundsDefinedForDynamicSize(): Boolean = false

    override fun prefetchTargetOnPrepare(): PrefetchTarget = PrefetchTarget.MEMORY_DECODED

    override fun prefetchTargetOnBoundsDefined(): PrefetchTarget = PrefetchTarget.MEMORY_DECODED
  }
}
